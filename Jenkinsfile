
import org.boozallen.plugins.sdp.binding.SdpBinding
import org.jenkinsci.plugins.workflow.cps.CpsThread
// for get branch file utils 
import org.jenkinsci.plugins.workflow.job.WorkflowJob
import org.jenkinsci.plugins.workflow.job.WorkflowRun
import org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject
import org.jenkinsci.plugins.workflow.multibranch.BranchJobProperty
import jenkins.branch.Branch
import hudson.model.ItemGroup
import jenkins.scm.api.SCMHead
import jenkins.scm.api.SCMRevision
import jenkins.scm.api.SCMFileSystem
import jenkins.scm.api.SCMSource
import jenkins.scm.api.SCMFile
import jenkins.scm.api.SCMRevisionAction
import hudson.scm.SCM
import hudson.Functions
import hudson.FilePath
import hudson.model.Node
import hudson.model.TopLevelItem
import hudson.model.Computer
import org.jenkinsci.plugins.workflow.steps.scm.GenericSCMStep
import org.jenkinsci.plugins.workflow.steps.scm.SCMStep
import org.jenkinsci.plugins.workflow.support.actions.WorkspaceActionImpl
import hudson.slaves.WorkspaceList
import org.jenkinsci.plugins.workflow.steps.scm.SCMStep
import jenkins.model.Jenkins
import hudson.AbortException
import org.jenkinsci.plugins.workflow.flow.FlowExecutionOwner
import hudson.model.Queue
import java.io.PrintStream
import hudson.model.TaskListener
import org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition
import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition

SCM scm = null
String filePath = "pipeline_config.groovy" 

// assumed this is being run from a job
CpsThread thread = CpsThread.current()
if (!thread){
    throw new IllegalStateException("CpsThread not present")
}

FlowExecutionOwner owner = thread.getExecution().getOwner()

TaskListener listener = owner.getListener()
PrintStream logger = listener.getLogger()        

Queue.Executable exec = owner.getExecutable()
if (!(exec instanceof WorkflowRun)) {
    throw new IllegalStateException("Must be run from a WorkflowRun, found: ${exec.getClass()}")
}

WorkflowRun build = (WorkflowRun) exec
WorkflowJob job = build.getParent()
ItemGroup<?> parent = job.getParent()

     
    
    if (parent instanceof WorkflowMultiBranchProject){
        // ensure branch is defined 
        BranchJobProperty property = job.getProperty(BranchJobProperty.class)
        if (!property){
            throw new IllegalStateException("inappropriate context")
        }
        Branch branch = property.getBranch()

        // get scm source for specific branch and ensure present
        // (might not be if branch deleted after job triggered)
        SCMSource scmSource = parent.getSCMSource(branch.getSourceId())
        if (!scmSource) {
            throw new IllegalStateException("${branch.getSourceId()} not found")
        }

        // attempt lightweight checkout 
        SCMHead head = branch.getHead()
        SCMRevision tip = scmSource.fetch(head, listener)
        if (tip){
            SCMRevision rev = scmSource.getTrustedRevision(tip, listener)
            SCMFileSystem fs = SCMFileSystem.of(scmSource, head, rev)
            if (fs){
                try {
                    SCMFile f = fs.child(filePath)
                    if (!f.exists()){
                        logger.println "${filePath} does not exist"
                        return null 
                    }
                    if(!f.isFile()){
                        logger.println "${filePath} is not a file"
                        return null 
                    } 
                    logger.println f.contentAsString()
                } catch (IOException | InterruptedException x) {
                    logger.println "Lightweight checkout failed - falling back to full checkout" 
                }
            }
            scm = scmSource.build(head,rev) 
        }else{
            scm = branch.getScm()
        }
    } else {
        CpsFlowDefinition definition = job.getDefinition() 
        if (definition instanceof CpsScmFlowDefinition){
            scm = definition.getScm()
        }else{
            return null 
        }
    }

    logger.println "scm = ${scm}"
