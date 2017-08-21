namespace java thrift.cmd

struct CallResult {
    1: string returnInfo;
    2: i32 returnCode;

}

service  CmdService {
    CallResult callCommand(1: i32 cmdNo, 2: string jsonCmd1, 3: string jsonCmd2)
}

