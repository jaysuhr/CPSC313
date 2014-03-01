.pos 0x100
 
main:
    irmovl  $0xCAFE0000,    %eax
    irmovl  cafebabe,       %ebx
    iaddl   $0xBABE,        %eax
    rmmovl  %eax,           (%ebx)
 
    irmovl  $0xCAFEBABE,    %eax
    irmovl  cafeoooo,       %ebx
    iandl   $0xFFFF0000,    %eax
    rmmovl  %eax,           (%ebx)
    halt
 
.pos 0x1000
cafebabe:
    .long 0x0
 
cafeoooo:
    .long 0x0
