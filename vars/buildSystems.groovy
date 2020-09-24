def mavenBuild() {
 
    sh "mvn clean package"
}

def nodeBuild() {
 
    sh "npm install"
}
return this
