module NumberRegex exposing (..)

import Regex exposing (..)


{-| Remove regex-special-character from strings.

escapeRegex "foo$bar^" == "foo\$bar\^"

-}
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
            "equal, as expetcted"

        False ->
            "different"
