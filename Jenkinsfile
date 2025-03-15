pipeline {
    agent any

    tools {
        maven "M3"
    }

    environment {
        GIT_REPO = 'git@github.com:ronaldjrombao/Comp367Lab3.git'
        BRANCH = 'master'
        DOCKER_IMAGE = 'ronaldjrombao/comp367lab3:latest'
    }

    stages {
        stage('Clone Repository') {
            steps {
                echo 'Cloning repository using SSH...'
                git branch: "${BRANCH}", url: "${GIT_REPO}", credentialsId: 'GithubSSh'
            }
        }

        stage('Build Package') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build and Push') {
            steps {
                script {
                    withDockerRegistry(credentialsId: 'DockerHubCreds', url: 'https://hub.docker.com/repositories/ronaldjrombao') {
                        dockerImage = docker.build("ronaldjrombao/comp367lab3:latest")
                        dockerImage.push()
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}