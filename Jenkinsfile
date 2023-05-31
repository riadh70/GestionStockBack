pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Checkout source code from version control
                git 'https://github.com/riadh70/GestionStockBack.git'
                
                // Set up environment variables if required
                
                // Execute Maven build
                sh 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                // Execute Maven tests
                sh 'mvn test'
            }
        }
        
        stage('Deploy') {
            steps {
                // Deploy the application to your environment (e.g., staging or production)
                sh 'mvn deploy'
            }
        }
    }

    post {
        always {
            // Perform post-build actions if required
        }
    }
}
