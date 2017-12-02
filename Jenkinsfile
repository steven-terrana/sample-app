
node {  
  checkout scm
  
  // set some git env vars
  org_repo  = sh(
    script: "git remote show -n origin | grep Fetch | sed 's/[^:].*[^:]*://'",
    returnStdout: true
  ).trim() - '.git'

  env.ORG_NAME = org_repo.split("/").getAt(-2)
  env.REPO_NAME = org_repo.split("/").getAt(-1)
  
  library identifier: "${env.REPO_NAME}@${env.BRANCH_NAME}", retriever: modernSCM([
    $class: 'GitSCMSource',
    remote: "${sh(script: "git remote get-url origin", returnStdout: true)}",
    credentialsId: 'github'
  ])
  
  test()

}
