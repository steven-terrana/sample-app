import sdp.SerializableConfigSlurper
node {  
  checkout scm
  
  println readFile("pipeline_config.groovy")
  tenant = new SerializableConfigSlurper().parse(readFile("pipeline_config.groovy")) 
  println tenant.prettyPrint()
  
}
