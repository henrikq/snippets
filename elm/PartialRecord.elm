module PartialRecord exposing (..)


super : { foo : String, bar : String }
super =
    { foo = "foo", bar = "bar" }


getFoo : { a | foo : String } -> String
getFoo { foo } =
    foo



-- output : String
-- output =
--     case num of
--         Just m ->
--             "Match " ++ m.match
--
--         Nothing ->
--             "No match"
