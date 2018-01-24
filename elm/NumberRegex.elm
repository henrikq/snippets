module NumberRegex exposing (..)

import Regex exposing (..)


num : Maybe Match
num =
    find (AtMost 1) (regex "\\d+([\\.\\,]\\d+)?") "321.14 foo"
        |> List.head


output : String
output =
    case num of
        Just m ->
            "Match " ++ m.match

        Nothing ->
            "No match"
