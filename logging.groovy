scan("30 seconds")

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
    totalSizeCap = "1GB" 
  }
}
appender("ABPMSERVICEWITHSTEP", RollingFileAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d %level Thread: %thread - %m%n"
  }
  rollingPolicy(SizeAndTimeBasedRollingPolicy) {
    fileNamePattern = "log/AbpmServiceWithStep-%d{yyyy-MM-dd}.%i.log"
    maxFileSize = "100MB"
    maxHistory = 30
    totalSizeCap = "1GB"
  }
}

logger("cn.com.agree.abpm.AbpmService",INFO,["ABPMSERVICE"],false)
logger("cn.com.agree.abpm.AbpmServiceWithStep",INFO,["ABPMSERVICEWITHSTEP"],true)
root(INFO,["ROLLING"])

