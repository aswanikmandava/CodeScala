package com.amandava.functions

object FactoryFunction extends App {
  // a factory function that creates a new object
  class Worker {
    def apply(): Unit = println("worker running ...")
  }
  val workerFactory = () => new Worker().apply()

  val w1 = workerFactory()
  val w2 = workerFactory()

  // real apps use this pattern
  // a factory function that takes a config object
  case class DbConfig(
    url : String,
    user: String,
    pass: String
  )

  class DbClient(url: String, user: String, pass: String)

  val dbFactory = (cfg: DbConfig) => new DbClient(cfg.url, cfg.user, cfg.pass)
  val myCfg  = DbConfig("jdbc:mysql://localhost:3306/mydb", "admin", "secret1")
  val oraCfg = DbConfig("jdbc:oracle:thin:@//localhost:1521/orcl", "admin", "secret2")
  val mysqlClient = dbFactory(myCfg)
  val oracleClient = dbFactory(oraCfg)

}
