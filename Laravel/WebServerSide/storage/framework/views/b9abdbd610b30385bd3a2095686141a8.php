<?php $__env->startSection('content'); ?>
    <h1>Aqui vês todos os users</h1>
    <br>
    <h6><?php echo e($cesaeInfo['name']); ?></h6>
    <h6><?php echo e($cesaeInfo['address']); ?></h6>
    <h6><?php echo e($cesaeInfo['email']); ?></h6>
    <br>
    <tbody>
        <?php $__currentLoopData = $contacts; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $contact): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
        <tr>
            <td><?php echo e($contact['id']); ?></td>
            <td> | <?php echo e($contact['name']); ?> | </td>
            <td><?php echo e($contact['phone']); ?> | </td><br>
        </tr>
        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
    </tbody>
    <br>
    <table class="table table-success">
        <thead>
          <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Password</th>
            <th scope="col">Updated at</th>
          </tr>
        </thead>
        <tbody>
        <?php $__currentLoopData = $allUsers; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $user): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
          <tr>
            <th scope="row"><?php echo e($user->id); ?></th>
            <td><?php echo e($user->name); ?></td>
            <td><?php echo e($user->email); ?></td>
            <td><?php echo e($user->address); ?></td>
            <td><?php echo e($user->password); ?></td>
            <td><?php echo e($user->updated_at); ?></td>
          </tr>
        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
        </tbody>
      </table>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.fo_layout', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Users\sw2024\Desktop\softdevcesae\PHP (Laravel)\WebServerSide\resources\views/users/all_users.blade.php ENDPATH**/ ?>