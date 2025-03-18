def call(String Project, String ImageTag, String credentialsID){
  withCredentials([usernamePassword(credentialsId: credentialsID, passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
      sh "docker login -u ${env.dockerhubuser} -p ${env.dockerhubpass}"
      sh "docker push ${env.dockerhubuser}/${Project}:${ImageTag}"
  }
 
}
