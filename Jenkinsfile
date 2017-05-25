import gsa.pipeline.*

// define clients
github  = new GitHub()
//utility = new Utility()

//| define branch name regex
master  = /^[Mm]aster$/
release = /^[Rr]elease-(\d+.)*\d$/
develop = /^[Dd]evelop(ment|)$/
hotfix  = /^[Hh]ot[Ff]ix-/
bugfix  = /^[Bb]ug[Ff]ix-/

//| checkout scm and determine build cause
stage("Initialize the Pipeline") {
    node {
        checkout scm
        //utility.fileCheck("Dockerfile")
        //language = utility.determineLaguage()
        cause = github.getBuildCause()    //| What action started this run
        parent = github.getBranchParent() //| The current branches parent
        stash BUILD_TAG
    }
}

//| dynamically load language library which implements stages
//library language


/*
    For pull requests - validate branching strategy.
    Perform CI stage if valid action.
 */
if (cause.equals("Pull Request")){
    //| pr metadata
    from   = env.BRANCH_NAME
    to     = env.CHANGE_TARGET

    //| route based on change target

    //| master only accepts changes from release and hotfix
    //| special error for develop.
    if (to ==~ master){
        if (from ==~ develop){
            throw new Exception("You can't merge to ${to} from ${from}. You must create a release branch.")
        }
        else if (!(from ==~ release || from ==~ hotfix)){
            throw new Exception("You can only merge to ${to} from a release or hotfix branch.")
        }
    }
    //| release & develop only accepts changes from children & master
    else if (to ==~ release || to ==~ develop){
        if (!(from ==~ master || to.equals(parent))){
            throw new Exception("${to} can only accept changes from ${parent} or master.")
        }
    }
    //| branches off of second-class branches only accept from children
    else{
        if (!to.equals(parent)){
            throw new Exception("${to} can only accept changes from ${parent}")
        }
    }
    // should exit if failed
    // do CI --> this should be from a shared library
    //new CI().run()

}

else if (cause.equals("Direct Commit")){
    branch = env.BRANCH_NAME

    // do CI --> this should be from a shared library


    if (branch ==~ release){
        // on approval - deploy to Staging
        // on approval - deploy to Prod & HF
    }
}

else if (cause.equals("Merge Commit")){
    branch     = env.BRANCH_NAME
    mergedFrom = github.getMergedFrom()

    if (branch ==~ develop){}
    else if (branch ==~ release){}
    else if (branch ==~ master){}
    else{}

}

