.pos 0x100
init:
    irmovl bottom,  %esp     # initialize stack

main:
    irmovl foo, %eax
    call (%eax)
 
return:
    irmovl  $0xCAFEBABE,    %eax
    irmovl  exits,         %ebx
    rmmovl  %eax,           (%ebx)
    halt
 
foo:
    irmovl  $0xCAFEBABE,    %eax
    irmovl  enters,         %ebx
    rmmovl  %eax,           (%ebx)
    ret
 
neverexec:
    irmovl  $0xCAFEBABE,    %eax
    irmovl  failure,         %ebx
    rmmovl  %eax,           (%ebx)
 
.pos 0x1000
enters:
    .long 0x0
exits:
    .long 0x0
failure:
    .long 0x0
 
#
# Stack (256 thirty-two bit words is more than enough here).
#
.pos 0x3000
bottom:
    .long 0x00000000          # bottom of stack.
