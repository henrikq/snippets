module NumberRegex exposing (..)

import Regex exposing (..)


escapeRegex : String -> String
escapeRegex str =
    let
        pattern =
            regex "[.*+?^${}()|[\\]\\\\]"

        replacer =
            \{ match } -> "\\" ++ match
    in
    Regex.replace All pattern replacer str


output : String
output =
    case escapeRegex "foo$bar^" == "foo\\$bar\\^" of
        True ->
            "equal"

        False ->
            "different"
