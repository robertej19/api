#!/bin/csh -f


set filename = $1

echo porting $filename

# replacing volume definition, removing obsolete hit_type
sed s/dimensions/parameters/ $filename | grep -v "hit_type" > port1
sed s/identifiers/touchableID/ port1 > port2
sed s/mfield/emfield/ port2 > port3

# replacing geant4 volume definitions
sed s/Box/G4Box/                       port3 > port4
sed s/Parallelepiped/G4Para/           port4 > port5
sed s/Sphere/G4Sphere/                 port5 > port6
sed s/Ellipsoid/G4Ellipsoid/           port6 > port7
sed s/Paraboloid/G4Paraboloid/         port7 > port8
sed s/Hype/G4Hype/                     port8 > port9
sed s/Tube/G4Tubs/                     port9 > port10
sed s/CTube/G4CutTubs/                 port10 > port11
sed s/EllipticalTube/G4EllipticalTube/ port11 > port12
sed s/Cons/G4Cons/                     port12 > port13
sed s/Trd/G4Trd/                       port13 > port14
sed s/ITrd/G4Trap/                     port14 > port15
sed s/Pgon/G4Polyhedra/                port15 > port16
sed s/Polycone/G4Polycone/             port16 > port17

mv port17 geometry3.pl
rm port*



