node {  
  checkout scm
  sh 'echo "adding line to readme from jenkins" >> README.md' 
  sh 'git ls remote-url'
  sh 'git add README.md && git commit -m "updaing readme from jenkins" && git push' 
}
