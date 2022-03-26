scan("30 seconds")
//日志文件设定
appender("ROLLING", RollingFileAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d %level %thread %mdc %logger{35} - %m%n"
  }
  rollingPolicy(SizeAndTimeBasedRollingPolicy) {
    fileNamePattern = "log/all-%d{yyyy-MM-dd}.%i.log"
    maxFileSize = "100MB"
    maxHistory = 30
    totalSizeCap = "1GB" 
  }
}
appender("ABPMSERVICE", RollingFileAppender) {  
  encoder(PatternLayoutEncoder) {
    pattern = "%d %level Thread: %thread - %m%n"
  } 
  rollingPolicy(SizeAndTimeBasedRollingPolicy) {
    fileNamePattern = "log/AbpmService-%d{yyyy-MM-dd}.%i.log"
    maxFileSize = "100MB"
    maxHistory = 30
    totalSizeCap = "2GB" 
  }
}
//单独输出AbpmService日志
logger("cn.com.agree.abpm.AbpmService",INFO,["ABPMSERVICE"],false)
root(INFO,["ROLLING"])

