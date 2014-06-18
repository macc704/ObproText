call pdfsplitall book res/book res/book.clog
call convertproject oo01
call convertproject oo02
call convertproject oo03
call convertproject oo04
call convertproject oo05
call convertproject oo06

cd res
rem call pdf2svgall
call pdf2epsallbygs
call svg2epsall
cd ..
