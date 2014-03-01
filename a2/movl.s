.pos 0x100
 
main:
    irmovl  $0x9,           %eax
    mrmovl  list(%eax,4),   %ebx
    irmovl  $0x8,           %eax
    rmmovl  %eax,           list(%eax, 4)
 
.pos 0x1000
cafebabe:
    .long 0x0
 
cafeoooo:
    .long 0x0
 
.pos 0x2000
list:
    .long 0x2000
    .long 0x1
    .long 0x2
    .long 0x3
    .long 0x4
    .long 0x5
    .long 0x6
    .long 0x7
eight:
    .long 0x0
data:
    .long 0xFFFFFFFF
