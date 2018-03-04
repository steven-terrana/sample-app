import sdp.SerializableConfigSlurper
node {  
  checkout scm
 
  tenant = new SerializableConfigSlurper().parse(readFile("pipeline_config.groovy")) 
  if (!tenant.organization) error "Organization specification required." 
  library tenant.organization
  println tenant.prettyPrint()
  println tenant.flatten()
  
}
