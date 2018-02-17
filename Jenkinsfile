node {  
  checkout scm
  
  master_config = readYaml file: "master-config.yml"
  
  master_config.environments.each{ app_env ->
    println app_env
    println app_env.getKey()
    println app_env.getValue().class
  }
  
}
