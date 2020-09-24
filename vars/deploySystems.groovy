def mavenDeploy(Map file) {
 sh "sudo rm -rf /opt/tomcat/webapps/${file.war}"
 sh "sudo cp ${file.war} /opt/tomcat/webapps/"

}

def nodeDeploy() {
 sh "set -x"
 sh "npm start & sleep 1"
 sh "echo \$! > .pidfile"
 sh "set +x"
 sh "echo 'Now...'"
 sh "echo 'Visit http://localhost:3000 to see your Node.js/React application in action.'"
 sh "echo '(This is why you specified the "args ''-p 3000:3000''" parameter when you'"
 sh "echo 'created your initial Pipeline as a Jenkinsfile.)'"
 
 input message: 'Finished using the web site? (Click "Proceed" to continue)'

 sh "echo 'The following command terminates the "npm start" process using its PID'"
 sh "echo '(written to ".pidfile"), all of which were conducted when "deliver.sh"'"
 sh "echo 'was executed.'"
 sh "set -x"
 sh "kill $(cat .pidfile)"
}
return this
