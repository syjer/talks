sumUncurried :: (Integer, Integer) -> Integer
sumUncurried (a, b) = a + b

sumCurried :: Integer -> Integer -> Integer
sumCurried a b = a + b
