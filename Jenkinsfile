@Library('sharedlib')
import static com.orcilatam.devops.Const.*
import static com.orcilatam.devops.Stage.*

pipeline {
  agent any

  stages {
    stage('Tests funcionales') {
      steps {
        script {
          testJUnit(this)
        }
      }
    }
  }
}
