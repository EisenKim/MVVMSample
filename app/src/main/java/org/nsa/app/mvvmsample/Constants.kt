package org.nsa.app.mvvmsample

class Constants {
    // 응답 코드
    open val RES_CODE_OK = "200"  // 정상 처리
    open val RES_CODE_ERROR = "500"  // 오류
    open val RES_CODE_NO_CERTIFICATION = "100"  // 인증 정보 없음
    open val RES_CODE_FAIL_LOGIN = "302"  // 로그인 실패
    open val RES_CODE_FAIL_DIAPAUSE = "322"  // 로그인 실패 - 휴면 회원
    open val RES_CODE_NO_PERMISSION = "403"  // 접근 권한 없음
    open val RES_CODE_SERVER_CHECK = "900"  // 서버 점검

    companion object {
        // 응답 result
        const val RESULT_SUCCESS = "SUCCESS"
        const val RESULT_FAIL = "FAIL"
        // 요청 키
        const val REQ_HEADER_X_TOKEN = "X-Auth-Token"  // 헤더 토큰 키
        const val CONNECTION_TIMEOUT = 30000
    }
}