package com.custom.mvp.model;

/**
 * 接口常量类
 *
 * @author hulin
 */
public interface Api {

    /**
     * 网络请求基本url
     */

    // 接口开发环境
    String APP_DOMAIN = "http://xjjk.jyxuangu.com";

    /* 预发布环境 @author Ysw created 2019/5/13 */
//    String APP_DOMAIN = "https://prepare-api.xjicr.com";

    // 接口正式环境
//    String APP_DOMAIN = "https://api.xjicr.com";


    /**
     * 网络请求返回成功码
     */
    String REQUEST_SUCCESS = "200";

    /**
     * post根地址
     */
    String COMMON_API = "index/index/Api";

    String REQUEST_METHOD = "POST";


    interface Config {
        // 签名key @author hulin.dev created at 2018/3/27
        String SIGN_KEY = "9f303fa34f6eae602690adb647f0c527";

        // 接口的升级通过版本来号区别。如：1.0.0 @author hulin.dev created at 2018/3/27
        String APIVERSION = "1.2.0";

        String APPID = "jinr_android_app";

        // 操作平台：1- IOS、2-Android、3-H5、4-web  @author hulin.dev created at 2018/3/27
        String PLATFORM = "2";
    }

    /**
     * 请求url的方法名常量
     *
     * @author hulin.dev 20180327
     */
    interface Method {

        /**
         * 系统初始化
         *
         * @author hulin.dev
         * @date 2018/6/9
         */
        String SYSTEM_INIT = "system.init";


        /**
         * 发送短信
         *
         * @author hulin.dev
         * @date 2018/5/21
         */
        String SEND_SMS = "sms.send";


        /**
         * 验证短信验证码
         *
         * @author Ysw created at 2019/3/11 16:19
         */
        String USER_VERIFY_SMS = "user.verify.sms";


        /**
         * 登录
         *
         * @author hulin.dev
         * @date 2018/5/21
         */
        String LOGIN = "user.login";


        /**
         * 判断用户是否注册
         *
         * @author Ysw created at 2019/3/11 12:32
         */
        String USER_IS_REGISTER = "user.is.register";


        /**
         * 找回密码
         *
         * @author Ysw created at 2019/3/15 11:04
         */
        String USER_RESET_LOGIN_PASSWORD = "user.reset.login.password";


        /**
         * 用户退出登录
         *
         * @author hulin.dev
         * @date 2018/6/9
         */
        String USER_LOGOUT = "user.logout";


        /**
         * 首页借贷状态列表
         *
         * @author Ysw created at 2019/3/12 18:42
         */
        String INDEX_LIST = "index.list";


        /**
         * 首页小喇叭消息列表
         *
         * @author Ysw created at 2019/3/12 18:40
         */
        String HORN_LIST = "horn.list";


        /**
         * 首页banner数据
         *
         * @author Ysw created at 2019/3/13 10:15
         */
        String AD_LIST = "ad.list";


        /**
         * 首页借贷需要选择的参数
         *
         * @author Ysw created at 2019/3/13 12:29
         */
        String INDEX_LOAN_PARAM = "index.loan.param";


        /**
         * 获取基本信息---工作信息
         *
         * @author Ysw created at 2019/3/15 14:21
         */
        String LOAN_APPLY_SUPPLEMENT_COMPANY = "loan.apply.supplement.company";


        /**
         * 提交基本信息---工作信息
         *
         * @author Ysw created at 2019/3/15 14:38
         */
        String LOAN_APPLY_SUPPLEMENT_COMPANY_EDIT = "loan.apply.supplement.company.edit";


        /**
         * 获取基本信息---工作单位--GPS位置信息
         *
         * @author Ysw created at 2019/3/15 14:52
         */
        String LOAN_APPLY_POSITION = "loan.apply.position";


        /**
         * 提交基本信息---工作单位--GPS位置信息
         *
         * @author Ysw created at 2019/3/15 14:52
         */
        String LOAN_APPLY_POSITION_EDIT = "loan.apply.position.edit";


        /**
         * 提交基本信息---学历婚姻信息
         *
         * @author Ysw created at 2019/3/15 15:13
         */
        String LOAN_APPLY_SUPPLEMENT_INCOME_EDIT = "loan.apply.supplement.income.edit";


        /**
         * 获取基本信息---居住信息
         *
         * @author Ysw created at 2019/3/15 15:32
         */
        String LOAN_APPLY_SUPPLEMENT_ADDRESS = "loan.apply.supplement.address";


        /**
         * 提交基本信息---居住信息
         *
         * @author Ysw created at 2019/3/15 15:33
         */
        String LOAN_APPLY_SUPPLEMENT_ADDRESS_EDIT = "loan.apply.supplement.address.edit";


        /**
         * 获取基本信息---联系人信息
         *
         * @author Ysw created at 2019/3/15 15:32
         */
        String LOAN_APPLY_CONTACT = "loan.apply.contact";


        /**
         * 提交基本信息---联系人信息
         *
         * @author Ysw created at 2019/3/15 15:33
         */
        String LOAN_APPLY_CONTACT_EDIT = "loan.apply.contact.edit";


        /**
         * 提交手机通讯录
         *
         * @author Ysw created at 2019/3/19 13:13
         */
        String LOAN_APPLY_ADDRESS_BOOK_EDIT = "loan.apply.address.book.edit";


        /**
         * 基本信息---运营商报告采集任务提交
         *
         * @author Ysw created at 2019/3/15 18:16
         */
        String LOAN_OPERATOR_COMMINT_TASK = "loan.operator.commint.task";


        /**
         * 基本信息---运营商报告采集状态查询
         *
         * @author Ysw created at 2019/3/15 18:17
         */
        String LOAN_OPERATOR_STATUS = "loan.operator.status";


        /**
         * 基本信息---运营商报告验证码输入
         *
         * @author Ysw created at 2019/3/15 18:17
         */
        String LOAN_OPERATOR_INPUT_DATA = "loan.operator.input.data";


        /**
         * 基本信息---获取社保查询城市列表
         *
         * @author Ysw created at 2019/3/12 18:46
         */
        String LOAN_SOCIAL_AREA = "loan.social.area";


        /**
         * 基本信息---获取社保登录元素
         *
         * @author Ysw created at 2019/3/12 18:46
         */
        String LOAN_SOCIAL_ELEMENT = "loan.social.element";


        /**
         * 基本信息---社保登录接口
         *
         * @author Ysw created at 2019/3/12 18:45
         */
        String LOAN_SOCIAL_LOGIN = "loan.social.login";


        /**
         * 基本信息---社保状态查询接口
         *
         * @author Ysw created at 2019/3/12 18:44
         */
        String LOAN_SOCIAL_STATUS = "loan.social.status";


        /**
         * 基本信息---社保信息输入接口
         *
         * @author Ysw created at 2019/3/12 18:44
         */
        String LOAN_SOCIAL_INPUT = "loan.social.input";


        /**
         * 基本信息---社保结果查询接口
         *
         * @author Ysw created at 2019/3/12 18:43
         */
        String LOAN_SOCIAL_RESULT = "loan.social.result";


        /**
         * 创建借款申请接口
         *
         * @author Ysw created at 2019/3/20 10:43
         */
        String LOAN_APPLY_ADD = "loan.apply.add";


        /**
         * 用户实名认证类型接口
         *
         * @author Ysw created at 2019/3/20 11:18
         */
        String USER_IS_IDENTITY = "user.is.identity";


        /**
         * 个人中心接口
         *
         * @author Ysw created at 2019/3/20 18:58
         */
        String USER_HOME = "user.home";


        /**
         * 个人用户信息接口
         *
         * @author Ysw created at 2019/3/22 20:11
         */
        String USER_MY_INFO = "user.my.info";


        /**
         * 上传图片接口
         *
         * @author Ysw created at 2019/3/21 10:01
         */
        String USER_UPLOAD_IDENTITYID = "user.upload.identityid";


        /**
         * 实名认证接口
         *
         * @author Ysw created at 2019/3/21 16:59
         */
        String USER_IDENTITY_AUTHENTICATION = "user.identity.authentication";


        /**
         * 活体人脸识别接口
         *
         * @author Ysw created at 2019/3/21 19:56
         */
        String USER_FACE_DETECT = "user.face.detect";


        /**
         * 设置交易密码接口
         *
         * @author Ysw created at 2019/3/21 16:19
         */
        String USER_SET_TRADERS_PASSWORD = "user.set.traders.password";


        /**
         * 验证交易密码接口
         *
         * @author Ysw created at 2019/3/21 16:20
         */
        String USER_VERIFY_TRADERS_PASSWORD = "user.verify.traders.password";


        /**
         * 银行卡列表
         *
         * @author Ysw created at 2019/3/21 16:22
         */
        String BANK_LIST = "bank.list";


        /**
         * 绑定银行卡接口
         *
         * @author Ysw created at 2019/3/21 16:25
         */
        String USER_BIND_CARD = "user.bind.card";


        /**
         * 绑卡短信验证码重新发送接口
         *
         * @author Ysw created at 2019/3/21 16:26
         */
        String USER_BIND_CARD_RESEND = "user.bind.card.resend";


        /**
         * 绑卡确认接口---短息验证接口
         *
         * @author Ysw created at 2019/3/21 16:29
         */
        String USER_BIND_CARD_CONFIRM = "user.bind.card.confirm";


        /**
         * 借款还款计划接口
         *
         * @author Ysw created at 2019/3/21 20:16
         */
        String LOAN_PLAN = "loan.plan";


        /**
         * 借款信息接口
         *
         * @author Ysw created at 2019/3/22 16:35
         */
        String LOAN_INFO = "loan.info";


        /**
         * 获取借款当期信息，判断当期已还清、当期待还、当期待还及逾期状态
         *
         * @author Ysw created at 2019/3/23 14:57
         */
        String LOAN_REPAY_CURRENT = "loan.repay.current";


        /**
         * 用户查验申请被拒
         *
         * @author Ysw created at 2019/3/23 18:11
         */
        String LOAN_REFUSE_CHECK = "loan.refuse.check";


        /**
         * 用户查验申请过期
         *
         * @author Ysw created at 2019/3/23 18:11
         */
        String LOAN_TIMEOUT_CHECK = "loan.timeout.check";


        /**
         * 用户查验放款失败
         *
         * @author Ysw created at 2019/3/30 15:09
         */
        String LOAN_PAYMENT_FAIL_CHECK = "loan.payment.fail.check";


        /**
         * 还款提交--用户主动还款
         *
         * @author Ysw created at 2019/3/23 18:22
         */
        String LOAN_REPAY_COMMIT = "loan.repay.commit";


        /**
         * 借款预还款计划
         *
         * @author Ysw created at 2019/3/23 18:39
         */
        String LOAN_PRE_PLAN = "loan.pre.plan";


        /**
         * 借款提交接口---填写完基本信息---社保信息之后调用
         *
         * @author Ysw created at 2019/3/23 18:46
         */
        String LOAN_COMMIT = "loan.commit";


        /**
         * 借款金额确认接口
         *
         * @author Ysw created at 2019/3/23 19:31
         */
        String LOAN_CONFIRM_COMMIT = "loan.confirm.commit";


        /**
         * 央行征信-央行征信报告查询接口
         *
         * @author Ysw created at 2019/3/25 18:58
         */


        String LOAN_CREDIT_REPORT_DATA = "loan.credit.report.data";
        /**
         * 央行征信-状态查询接口
         *
         * @author Ysw created at 2019/3/25 18:56
         */
        String LOAN_CREDIT_STATUS = "loan.credit.status";


        /**
         * 上传用户已经安装的APP信息
         *
         * @author Ysw created at 2019/3/26 18:08
         */
        String LOAN_APPLY_APP_EDIT = "loan.apply.app.edit";


        /**
         * 上传用户短信
         *
         * @author Ysw created at 2019/3/26 20:28
         */
        String LOAN_APPLY_SMS_EDIT = "loan.apply.sms.edit";


        /**
         * 获取手续费弹窗信息
         *
         * @author Ysw created at 2019/4/3 9:33
         */
        String LOAN_CONFIRM_BEFORE_COMMIT = "loan.confirm.before.commit";

        /**
         * 个人信息保存 1.2.0
         *
         * @author hulin.dev
         * @date 2019/5/17
         */
        String LOAN_APPLY_SUPPLEMENT_SELF_EDIT = "loan.apply.supplement.self.edit";

        /**
         * 获取个人基本信息
         *
         * @author hulin.dev
         * @date 2019/5/17
         */
        String LOAN_APPLY_SUPPLEMENT_SELF = "loan.apply.supplement.self";

        /**
         * 申请资料卡信息
         *
         * @author Steven created at 2019/5/21
         */
        String LOAN_APPLY_PROCESS = "loan.apply.process";

        /**
         * 前置资料卡信息
         *
         * @author Ysw created at 2019/5/23 10:42
         */
        String LOAN_APPLY_PRE_PROCESS = "loan.apply.pre.process";


        /**
         * 贷超列表数据
         *
         * @author Ysw created at 2019/5/23 11:48
         */
        String AD_MARKET_LIST = "ad.market.list";

        /**
         * 还款状态查询
         *
         * @author Steven created at 2019/5/22
         */
        String LOAN_REPAY_COMMIT_STATUS = "loan.repay.commit.status";

        /**
         * 借款进度条
         *
         * @author hulin.dev
         * @date 2019/5/24
         */
        String LOAN_APPLY_PERCENT = "loan.apply.percent";


        /**
         * 获取倒计时时间
         *
         * @author Ysw created at 2019/5/24 13:22
         */
        String LOAN_COUNT_DOWN = "loan.count.down";


        /**
         * 获取银行卡卡号后四位
         *
         * @author Ysw created at 2019/7/8 17:41
         */
        String USER_CARD_INFO = "user.card.info";


        /**
         * 重置交易密码验证卡号
         *
         * @author Ysw created at 2019/7/8 17:43
         */
        String USER_RESET_TRADERS_PASSWORD_START = "user.reset.traders.password.start";


        /**
         * 重置交易密码
         *
         * @author Ysw created at 2019/7/8 17:43
         */
        String USER_RESET_TRADERS_PASSWORD_END = "user.reset.traders.password.end";


        /**
         * 提前结清详情
         *
         * @author Ysw created at 2019/7/10 11:32
         */
        String LOAN_REPAY_ALL = "loan.repay.all";


        /**
         * 提交提前结清
         *
         * @author Ysw created at 2019/7/10 11:32
         */
        String LOAN_REPAY_ALL_COMMIT = "loan.repay.all.commit";


        /**
         * 重新绑定卡申请
         *
         * @author Ysw created at 2019/7/10 11:35
         */
        String USER_CARD_REBIND = "user.card.rebind";


        /**
         * 重新绑卡确认
         *
         * @author Ysw created at 2019/7/10 11:37
         */
        String USER_CARD_REBIND_CONFIRM = "user.card.rebind.confirm";
    }
}
