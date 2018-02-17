node {  
  checkout scm
  
  master_config = readYaml file: "master-config.yml"
  
  master_config.environments.each{ name, props ->
    println name
    println props
  }
  
}
