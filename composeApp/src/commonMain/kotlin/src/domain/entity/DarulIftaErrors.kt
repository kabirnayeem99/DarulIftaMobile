package src.domain.entity

enum class DarulIftaErrors {
    // Network errors
    NETWORK_TIMEOUT,
    NETWORK_UNREACHABLE,
    API_RATE_LIMITED,
    API_BLOCKED,

    // Parsing errors
    MALFORMED_HTML,
    INVALID_DATA_STRUCTURE,
    DATA_INCONSISTENCY,

    // Database errors
    DATABASE_CONNECTION_FAILED,
    INSERT_FAILED,
    UPDATE_FAILED,
    DELETE_FAILED,
    CONSTRAINT_VIOLATION,

    // App logic errors
    INVALID_USER_INPUT,
    DATA_PROCESSING_ERROR,
    UNEXPECTED_APP_STATE,

    // Other potential errors
    UNKNOWN_ERROR
}