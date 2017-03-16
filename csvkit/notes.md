## guns.csv

```
state,county,fips,nsn,item_name,quantity,ui,acquisition_cost, ...
NE,ADAMS,31001.0,1005-00-589-1271,"RIFLE,7.62 MILLIMETER",1.0,Each,138.0, ...
NE,ADAMS,31001.0,1005-00-589-1271,"RIFLE,7.62 MILLIMETER",1.0,Each,138.0, ...
```

## csvkit

```
$ head -3 guns.csv | csvcut -c 1-5 | csvlook
| state | county |   fips | nsn              | item_name             |
| ----- | ------ | ------ | ---------------- | --------------------- |
| NE    | ADAMS  | 31 001 | 1005-00-589-1271 | RIFLE,7.62 MILLIMETER |
| NE    | ADAMS  | 31 001 | 1005-00-589-1271 | RIFLE,7.62 MILLIMETER |
```
