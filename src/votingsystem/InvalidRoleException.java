package votingsystem;
// Custom exception for invalid user role
class InvalidRoleException extends Exception {
    public InvalidRoleException(String message) {
        super(message);
    }
}
