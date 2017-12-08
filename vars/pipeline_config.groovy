def call(){
  if (fileExists("pipeline-config.yml") ) return readYaml('pipeline-config.yml')
  else return null
}

def library(String lib){
  println this.call()
}
