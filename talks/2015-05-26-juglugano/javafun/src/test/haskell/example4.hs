example4Foldl :: Integer
example4Foldl = foldl (\a b -> a + b) 0 [1,2,3,4]


-- example of foldl as a superset of map :D

example4Map mapFun list = foldr (\x xs -> (mapFun x):xs) [] list
