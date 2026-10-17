pipeline {
    agent any
    
    tools {
        jdk 'Java-21'
        maven 'Maven-3.9.12'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Hitesh-dev85/Employee-salary-webapp.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
	stage('Test') {
	    steps {
		sh 'mvn test'
	    }
	}
    }
}
