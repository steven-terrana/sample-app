node {  
  checkout scm
  
  master_config = readYaml file: "master-config.yml"
  
  master_config.environments.each{ app_env ->
    def name = app_env.getKey()
    def props = app_env.getValue() as HashMap
    this.getBinding().setVariable(name, props.asImmutable())
  }
  
  println "ENVIRONMENT: ${dev.long_name}"
  println "NUMBER BANANAS: ${dev.number_bananas}"
  
}
