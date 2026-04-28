public class User {
    
    private String userId;
    private String userName;
    private String userPassword;
    private int userAge;
    private String userEmail;
    
    
        public void setUserId(String userId) {
            this.userId = userId;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }
        public void setUserAge(int userAge) {
            this.userAge = userAge;
        }
        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;

        }

        @Override
        public String toString() {
            return "User{" +
                    "userId='" + userId + '\'' +
                    ", userName='" + userName + '\'' +
                    ", userPassword='" + userPassword + '\'' +
                    ", userAge=" + userAge +
                    ", userEmail='" + userEmail + '\'' +
                    '}';
    }
}

