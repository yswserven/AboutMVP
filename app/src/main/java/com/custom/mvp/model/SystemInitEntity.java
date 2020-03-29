package com.custom.mvp.model;

import java.io.Serializable;

public class SystemInitEntity implements Serializable {


    /**
     * token_status : 0
     * register_protocol : 注册协议
     * protocol : 其他相关协议
     * channel_status : 是否跳过社保，0 不显示跳过，1 显示跳过
     * upgrade : {"upgrade_way":0,"app_v":"","app_title":"","app_desc":"","app_url":"","dialog_repeat":0,"origin_v":"1.0.0"}
     */

    private String token_status;
    private String register_protocol;
    private String protocol;
    private String channel_status;
    private String service_tel;
    private String social_help;
    private String youmeng_switch;
    private UpgradeBean upgrade;

    public String getYoumeng_switch() {
        return youmeng_switch;
    }

    public void setYoumeng_switch(String youmeng_switch) {
        this.youmeng_switch = youmeng_switch;
    }

    public String getService_tel() {
        return service_tel;
    }

    public void setService_tel(String service_tel) {
        this.service_tel = service_tel;
    }

    public String getSocial_help() {
        return social_help;
    }

    public void setSocial_help(String social_help) {
        this.social_help = social_help;
    }

    public String getChannel_status() {
        return channel_status;
    }

    public void setChannel_status(String channel_status) {
        this.channel_status = channel_status;
    }

    public String getRegister_protocol() {
        return register_protocol;
    }

    public void setRegister_protocol(String register_protocol) {
        this.register_protocol = register_protocol;
    }

    public String getToken_status() {
        return token_status;
    }

    public void setToken_status(String token_status) {
        this.token_status = token_status;
    }


    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public UpgradeBean getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(UpgradeBean upgrade) {
        this.upgrade = upgrade;
    }

    public static class UpgradeBean implements Serializable {
        /**
         * upgrade_way : 0
         * app_v :
         * app_title :
         * app_desc :
         * app_url :
         * dialog_repeat : 0
         * origin_v : 1.0.0
         */

        private String upgrade_way;
        private String app_v;
        private String app_title;
        private String app_desc;
        private String app_url;
        private String dialog_repeat;
        private String origin_v;

        public String getUpgrade_way() {
            return upgrade_way;
        }

        public void setUpgrade_way(String upgrade_way) {
            this.upgrade_way = upgrade_way;
        }

        public String getApp_v() {
            return app_v;
        }

        public void setApp_v(String app_v) {
            this.app_v = app_v;
        }

        public String getApp_title() {
            return app_title;
        }

        public void setApp_title(String app_title) {
            this.app_title = app_title;
        }

        public String getApp_desc() {
            return app_desc;
        }

        public void setApp_desc(String app_desc) {
            this.app_desc = app_desc;
        }

        public String getApp_url() {
            return app_url;
        }

        public void setApp_url(String app_url) {
            this.app_url = app_url;
        }

        public String getDialog_repeat() {
            return dialog_repeat;
        }

        public void setDialog_repeat(String dialog_repeat) {
            this.dialog_repeat = dialog_repeat;
        }

        public String getOrigin_v() {
            return origin_v;
        }

        public void setOrigin_v(String origin_v) {
            this.origin_v = origin_v;
        }
    }
}
