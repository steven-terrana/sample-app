node {  
  checkout scm  
  withCredentials([usernamePassword(credentialsId: 'github', passwordVariable: 'PAT', usernameVariable: 'USER')]) {
    sh "git config --global user.name \"${USER}\""
    sh "git config --global user.email \"you@example.com\""
    sh 'echo "adding line to readme from jenkins" >> README.md'
    git_url = sh(script: "git remote get-url origin", returnStdout: true).trim() - 'https://'
    sh 'git commit -am "adding a line to the readme from jenkins"'
    sh "git push https://${USER}:${PAT}@${git_url}"
  }

  
}
