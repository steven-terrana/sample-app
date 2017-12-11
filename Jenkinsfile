node {  
  checkout scm
  sh 'echo "adding line to readme from jenkins" >> README.md' 
  git_url = sh script: "git remote get-url origin", returnStdout: true
  echo git_url
  echo git_url - "https://" 
  sh 'git add README.md && git commit -m "updaing readme from jenkins" && git push' 
}
