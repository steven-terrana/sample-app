
node {  
  checkout scm
 
  library identifier: "steven-terrana@master", retriever: modernSCM([
    $class: 'GitSCMSource',
    remote: "${sh(script: "git remote get-url origin", returnStdout: true)}",
    credentialsId: 'github'
  ])
  
  test()

}
