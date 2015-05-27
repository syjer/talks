import Data.Maybe

doubleFun x = x * 2
failureFun x = Nothing

toStringFun :: Integer -> String
toStringFun x = show x


pyramidOfChecks :: Maybe String
pyramidOfChecks = let val = Just 42 in
  if isJust val then
    let maybeVal = failureFun (doubleFun (fromJust val)) in
      if isJust maybeVal then
        Just (toStringFun (fromJust maybeVal))
      else
        Nothing
  else
    Nothing

betterVersion :: Maybe String
betterVersion = do
  val <- Just 42
  maybeVal <- failureFun (doubleFun (val))
  return (toStringFun maybeVal)

desugaredVersion :: Maybe String
desugaredVersion = (Just 42) >>= (\val -> failureFun (doubleFun(val))) >>= (\val -> Just (toStringFun (val)))
