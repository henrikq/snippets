module VerbalExpressionTest exposing (..)

import Regex exposing (HowMany(..), Regex)
import VerbalExpressions exposing (..)


tester : Regex
tester =
    verex
        |> find "\\d"
        |> toRegex


testMe : String
testMe =
    "1234 abc \\d"


{-| Use Regex.contains to determine if we have a url

    result == True

-}
result : List Regex.Match
result =
    Regex.find All tester testMe


output : String
output =
    case List.head result of
        Just m ->
            "Match " ++ m.match

        Nothing ->
            "No match"
