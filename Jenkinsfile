import sdp.SerializableConfigSlurper
node {  
  checkout scm
  
  tenant = new SerializableConfigSlurper().parse(readFile("pipeline_config.groovy")) 
  println tenant.prettyPrint()
  println tenant.flatten()
  
}
