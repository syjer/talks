eitherExample = do
  val <- Right 42
  val2 <- Right (val * 2)
  val3 <- Left "error"
  val4 <- Right (val3 * 2)
  return val4
