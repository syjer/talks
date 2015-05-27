

doubler :: Integer -> Integer
doubler v = v * 2

sum42 :: (Integer -> Integer) -> Integer
sum42 f = (f 42) + (f 42)

apply2 :: (Integer -> Integer) -> (Integer -> Integer)
apply2 f = f . f
-- shorter : apply2 = (.)
