pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
               sh 'mvn --version'
               sh 'mvn clean install'
            }
        }
    }
}

