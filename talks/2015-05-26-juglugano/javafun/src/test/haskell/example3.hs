
mapExample1 :: Maybe Integer
mapExample1 = fmap (\a -> a * 2) (Just 42)

mapExample2 :: [Integer]
mapExample2 = map (\i -> i * 2) [0,1,2,3,4]
