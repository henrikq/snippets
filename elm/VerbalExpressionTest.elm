module VerbalExpressionTest exposing (..)

import Regex exposing (HowMany(..), Regex)
import VerbalExpressions exposing (..)


output : String
output =
    case
        Regex.find
            All
            (verex
                |> find "^.*$"
                |> toRegex
            )
            "will it match everything or just ^.*$ ?"
            |> List.head
    of
        Just m ->
            "It matches: \"" ++ m.match ++ "\""

        Nothing ->
            "No match"



{--
$ run-elm VerbalExpressionTest.elm
It matches: "will it match everything or just ^.*$ ?"

It maches everything.
In other words, VerbalExpressions interprits strings as regex, not litterals
--}
