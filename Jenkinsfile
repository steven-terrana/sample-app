import sdp.SerializableConfigSlurper
node {  
  checkout scm
 
  tenant = new SerializableConfigSlurper().parse(readFile("pipeline_config.groovy")) 
  library tenant.organization
  println tenant.prettyPrint()
  println tenant.flatten()
  
}
