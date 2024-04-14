package com.acttopia.main.global.common.basic.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
    var msg: String,
    val status: HttpStatus,
    val code: String
) {
    // 범용 error code
    FORBIDDEN_ERROR("접근 권한이 없습니다.", HttpStatus.FORBIDDEN, "0002"),
    UNAUTHORIZED_ERROR("로그인이 필요한 작업입니다.", HttpStatus.UNAUTHORIZED, "0001"),
    UNEXPECTED_ERROR("서버에서 오류가 발생하였습니다.", HttpStatus.INTERNAL_SERVER_ERROR, "500"),
    PAGE_NOT_FOUND("엔드포인트를 찾지 못했습니다.", HttpStatus.NOT_FOUND, "404"),
    NOT_SUPPORT_TYPE_REQUEST("지원하지 않는 콘텐츠 타입입니다.", HttpStatus.BAD_REQUEST, "4003"),
    VALIDATION_FAILED_ERROR("데이터 검증에 실패하였습니다.", HttpStatus.BAD_REQUEST, "4004"),
    WRONG_BODY_ERROR("데이터가 정상적으로 들어오지 않았습니다.", HttpStatus.BAD_REQUEST, "4005"),
    REQUEST_REJECTION_ERROR("요청이 거부되었습니다.", HttpStatus.BAD_REQUEST, "4006"),
    METHOD_NOT_SUPPORT_ERROR("지원하지 않는 메소드입니다.", HttpStatus.BAD_REQUEST, "4007"),
    NOT_ENOUGH_DATA_ERROR("필수 요청 데이터가 정상적으로 입력되지 않았습니다.", HttpStatus.BAD_REQUEST, "4001"),

    // account
    USER_CONFLICT("해당 이메일은 이미 가입이 완료되었습니다.", HttpStatus.CONFLICT, "A209"),
    USER_NOT_FOUND("계정을 찾을 수 없습니다.", HttpStatus.OK, "A204"),
    USER_NOT_SAVED("회원가입에 실패하였습니다.", HttpStatus.BAD_REQUEST, "A4001"),

    // S - Slot
    SLOT_CONFLICT("이미 존재하는 슬롯입니다.", HttpStatus.CONFLICT, "S209"),
    SLOT_OVER("슬롯이 허용범위를 초과하였습니다.", HttpStatus.FORBIDDEN, "S403"),

    // TK - ToKen
    TOKEN_NOT_VALID_ERROR("토큰 값이 정상적이지 않습니다.", HttpStatus.BAD_REQUEST, "TK400"),
    JWT_EXPIRED_ERROR("토큰이 만료되었습니다.", HttpStatus.UNAUTHORIZED, "TK401"),

}