package com.biz.zq.exception;

public interface ApiException {

    enum User implements ExceptionType {

        USER_MOT_EXIST(100, "用户不存在！");
        private int code;

        private String description;

        User(int code, String description) {
            this.code = code;
            this.description = description;
        }

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }
}
