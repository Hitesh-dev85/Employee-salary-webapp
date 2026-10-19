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
	stage('SonarQube Analysis') {
	    steps {
		withSonarQubeEnv('SonarQube') {
		    script {
			def scannerHome = tool 'SonarScanner'
			
			sh """
			 ${scannerHome}/bin/sonar-scanner \
			 -Dsonar.projectKey=employee-salary-webapp \
			 -Dsonar.projectName=Employee-Salary-Webapp \
			 -Dsonar.sources=src/main/java \
			 -Dsonar.tests=src/test/java \
			 -Dsonar.java.binaries=target/classes
			"""
		    }
		}
	    }
	}
    }
}
